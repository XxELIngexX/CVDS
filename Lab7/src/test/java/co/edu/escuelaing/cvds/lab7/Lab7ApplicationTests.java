package co.edu.escuelaing.cvds.lab7;

import static org.mockito.ArgumentMatchers.any;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class Lab7ApplicationTests {
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	private Employee employee;
	@BeforeEach
	public void setup(){
		employee = new Employee("1", "cesar", "amaya", "Developer", 50000);
	}
	// JUnit test for getEmployeeById method
	@DisplayName("JUnit test for getEmployeeById method")
	@Test
	public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject(){
		// given
		given(employeeRepository.findById("1")).willReturn(Optional.of(employee));
		// when
		Employee savedEmployee = employeeService.getEmployee(employee.getId()).get();
		// then
		assertThat(savedEmployee).isNotNull();

	}
	@DisplayName("JUnit test for getEmptyEmployeeList method")
	@Test
	public void givenNoEmployees_whenGetEmployeeList_thenReturnEmptyList() {
		// given
		given(employeeRepository.findAll()).willReturn(Collections.emptyList());

		// when
		List<Employee> employees = employeeService.getAllEmployees();

		// then
		assertThat(employees).isEmpty();
	}
	@DisplayName("JUnit test for createEmployee method when no employees are registered")
	@Test
	public void givenNoEmployees_whenCreateEmployee_thenCreationSuccessful() {
		// given

		given(employeeRepository.save(any(Employee.class))).willReturn(new Employee("2", "sebas", "zamora", "Developer", 50000));

		// when
		Employee newEmployee = employeeService.addEmployee(new Employee("2", "sebas", "zamora", "Developer", 50000));

		// then
		assertThat(newEmployee).isNotNull();
		assertThat(newEmployee.getId()).isEqualTo("2");
		assertThat(newEmployee.getFirstName()).isEqualTo("sebas");
		assertThat(newEmployee.getLastName()).isEqualTo("zamora");
		assertThat(newEmployee.getRole()).isEqualTo("Developer");
		assertThat(newEmployee.getSalary()).isEqualTo(50000);
	}
	@DisplayName("JUnit test for deleteEmployee method")
	@Test
	public void givenEmployeeId_whenDeleteEmployee_thenNothing(){
		// given - precondition or setup
		String employeeId = "1";

		willDoNothing().given(employeeRepository).deleteById(employeeId);

		// when -  action or the behaviour that we are going test
		employeeService.deleteEmployee(employeeId);

		// then - verify the output
		verify(employeeRepository, times(1)).deleteById(employeeId);
	}
	@DisplayName("JUnit test for deleteEmployee and then getEmployee method when one employee is registered")
	@Test
	public void givenOneEmployee_whenDeleteEmployeeAndThenGetEmployee_thenNoResultReturned() {
		// given - registrando un empleado
		given(employeeRepository.findById("1")).willReturn(Optional.of(employee));

		// when - eliminando el empleado
		employeeService.deleteEmployee("1");

		// then - verificando que la consulta no retorne ningún resultado
		Optional<Employee> result = employeeService.getEmployee("1");
		assertThat(result).isEmpty();
	}


}
