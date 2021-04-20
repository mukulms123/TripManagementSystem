package TripManagementSystem;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.User;
import com.cg.tms.service.IUserServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IUserServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IUserServiceImplTest {

		public  User addNewUser(User user) {
			return null;
		}
		public User signIn(User user) {
			return null;
		}
		public User signOut(User user) {
			return null;
		}
}
