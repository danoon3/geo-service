import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @Test
    void localeTest() {
        LocalizationService localizationService = new LocalizationServiceImpl();

        String result = localizationService.locale(Country.BRAZIL);

        String expected = "Welcome";

        Assertions.assertEquals(expected, result);
    }
}
