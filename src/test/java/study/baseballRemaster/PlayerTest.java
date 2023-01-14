package study.baseballRemaster;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("유저는 임의의 숫자 3자리를 입력한다.")
    void userInputTest() {
        assertThatCode(() ->
                new Player("123")
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("유저가 3자리 숫자 이상을 입력했을때 예외처리를 해야한다.")
    void userOverInputException() {
        // given & when & then
        assertThatThrownBy(() -> new Player("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저가 입력한 임의의 숫자 3자리를 정수형 배열로 반환해야 한다.")
    void userInputConvertArrayTest() {
        // given
        Player player = new Player("123");
        // when
        List<Integer> userInput = player.getUserNumbers();
        // then
        assertThat(userInput).hasSize(3);
    }
}
