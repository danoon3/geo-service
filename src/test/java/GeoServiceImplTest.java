import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    void locationByIpTest() {
        GeoService geoService = new GeoServiceImpl();

        Location location = geoService.byIp("127.0.0.1");

        Country result = location.getCountry();

        Country expected = null;

        Assertions.assertEquals(expected, result);
    }
}
