import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    private boolean screaming = false;

    private InlineKeyboardMarkup keyboardM1;
    private InlineKeyboardMarkup keyboardM2;

    @Override
    public String getBotUsername() {
        return "qwer1210_bot";
    }

    @Override
    public String getBotToken() {
        return "7215048215:AAFhkmv9A4CW-aziDqhQ0ZyCECzSI6ypPLM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        User user = message.getFrom();
        Long id = user.getId();
        System.out.println("Name \"" + user.getFirstName() + "\" wrote \"" + message.getText() + "\"" + " witch id \"" + id + "\"");
//        sendMessage(id, message.getText());
        copyMessage(id, message.getMessageId());
    }

    public void sendMessage(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build(); //Message content

        try {
            execute(sm); //Actually sending the message
        } catch (TelegramApiException tae) {
            throw new RuntimeException(); //Any error will be printed here
        }
    }

    public void copyMessage(Long who, Integer msgId) {
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(who.toString()) //We copy from the user
                .chatId(who.toString()) //And send it back to him
                .messageId(msgId) //Specifying what message
                .build();

        try {
            execute(cm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }
    public void sendMenu(Long who, String txt, InlineKeyboardMarkup kd2) {
        SendMessage sm = SendMessage.builder().chatId(who.toString())
                .parseMode("HTML").text(txt).
                replyMarkup(kd2).build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}