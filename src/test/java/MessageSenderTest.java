import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderTest {

    @Test
    void MessageSenderRussiaTest() {
        String ip = "172.0.0.0";

        GeoService geoServiceMock = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceMock.byIp(ip))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceMock.locale(Country.RUSSIA))
                .thenReturn("Привет");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);

        Map<String, String> headers = new HashMap<String, String>();

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Привет";
        String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void MessageSenderEngTest() {
        String ip = "96.135.12.58";

        GeoService geoServiceMock = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceMock.byIp(ip))
                .thenReturn(new Location("Boston", Country.USA, null, 3));

        LocalizationService localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceMock.locale(Country.USA))
                .thenReturn("Hi");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);

        Map<String, String> header = new HashMap<String, String>();

        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Hi";
        String result = messageSender.send(header);

        Assertions.assertEquals(expected, result);
    }
}
