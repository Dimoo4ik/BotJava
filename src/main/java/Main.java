
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        InlineKeyboardMarkup keyboardM1;
        InlineKeyboardMarkup keyboardM2;
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        telegramBotsApi.registerBot(bot);

        /*bot.sendMessageWithButtons(5095047491L, "Hello World! My name is Ogar Mike");*/


        var next = InlineKeyboardButton.builder()
                .text("Next").callbackData("next")
                .build();

        var back = InlineKeyboardButton.builder()
                .text("Back").callbackData("back")
                .build();

        var url = InlineKeyboardButton.builder()
                .text("Tutorial")
                .url("https://core.telegram.org/bots/api")
                .build();

        /*keyboardM1 = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(next)).build();
*/
//Buttons are wrapped in lists since each keyboard is a set of button rows
        keyboardM2 = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(back))
                .keyboardRow(List.of(url))
                .keyboardRow(List.of(next))
                .build();

        bot.sendMenu(5095047491L, "Hello World! My name is Dima", keyboardM2);
    }
}