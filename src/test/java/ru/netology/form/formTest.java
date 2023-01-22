package ru.netology.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class formTest {
    @Test
    void shouldMakeConfirm() {
        Selenide.open("http://localhost:9999");
        $("[data-test-id = 'name'] input").setValue("Иван Иванов");
        $("[data-test-id = 'phone'] input").setValue("+79003170909");
        $("[data-test-id = 'agreement']").click();
        $$("button").find(Condition.exactText("Продолжить")).click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
