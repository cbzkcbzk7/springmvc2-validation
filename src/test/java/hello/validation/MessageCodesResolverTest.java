package hello.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName    : hello.validation
 * fileName       : MessageCodesResolverTest
 * author         : Sora
 * date           : 2024-07-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-16        Sora       최초 생성
 */
public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
      String[] messageCodes =  codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item","required");
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }

        assertThat(messageCodes).containsExactly(
        "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
