import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage()
                .setChatId(chatId)
                .setText(message.getText());
        SendMessage sendUsername = new SendMessage()
                .setChatId((long) 280890167)
                .setText("@" + update.getMessage().getChat().getUserName() + " " + update.getMessage().getChat().getFirstName() + " " + update.getMessage().getChat().getLastName());

        if (!message.getText().equals("/start")) {
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        try {
            execute(sendUsername);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "binam_1bot";
    }

    @Override
    public String getBotToken() {
        return "934450245:AAHDaqhWmnQneqxE0OLx4_vLeYvqocsqBiw";
    }
}
