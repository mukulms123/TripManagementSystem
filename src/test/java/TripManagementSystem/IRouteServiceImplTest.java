package TripManagementSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repository.IRouteRepository;
import com.cg.tms.service.IRouteServiceImpl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class IRouteServiceImplTest {

	@Spy
	@InjectMocks
	IRouteServiceImpl rService;
	
	@Mock
	IRouteRepository rRep;
	
	@Test 
	public void addRoute()
	{
		String routeId = "R1";
		String routeFrom = "Jaipur";
		String routeTo = "Delhi";
		double fare = 600;
		Route route = mock(Route.class);
		route.setRouteId(routeId);
		route.setRouteFrom(routeFrom);
		route.setRouteTo(routeTo);
		route.setFare(fare);
		when(rRep.save(route)).thenReturn(route);
		Route result = rService.addRoute(route);
		Assertions.assertSame(result, route);
		verify(rRep).save(route);
	}
	
	@Test
	public void updateRoute() throws RouteNotFoundException
	{
		String routeId = "R1";
		String routeFrom = "Delhi";
		String routeTo = "Himachal";
		double fare = 600;
		Route route = mock(Route.class);
		when(route.getRouteId()).thenReturn(routeId);
		when(route.getRouteFrom()).thenReturn(routeFrom);
		when(route.getRouteTo()).thenReturn(routeTo);
		when(route.getFare()).thenReturn(fare);
		Optional<Route> optional = Optional.of(route);
		when(rRep.findById(routeId)).thenReturn(optional);
		when(rRep.save(route)).thenReturn(route);
		Route result = rService.updateRoute(route);
		Assertions.assertNotNull(result);
		Assertions.assertSame(result, route);
	}
}
