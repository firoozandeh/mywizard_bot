package ru.home.mywizard_bot;


import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


public class MyWizardTelegramBot extends TelegramWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;


//    public MyWizardTelegramBot(DefaultBotOptions botOptions) {
//        super(botOptions);
//    }


    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
//            if (update.getMessage().getText().equals("/start")) {
//            if (update.getMessage().getText().equals("/start Y29tNTM3ODE=")) {

//            try {
//                execute(new SendMessage(chat_id, "Hi " + update.getMessage().getText()));
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//                System.out.println("********* ngrok Is HERE **********");
//            String link = "tg://resolve?domain=proxy&server=88.218.17.166&port=443&secret=ee67545f8a258843b16aadd3c67220de2f7777772e676f6f676c652e636f6d";
                String link = "https://t.me/proxy?server=88.218.17.166&port=443&secret=ee67545f8a258843b16aadd3c67220de2f7777772e676f6f676c652e636f6d";

                try {
                    SendMessage sendMessage = new SendMessage().setChatId(chat_id).setText("⚡⚡⚡    New MTP Proxy    ⚡⚡⚡\n                  Quality: ★★★★☆                              \n" +
                            "                  Ping: 0.133s       \uD83D\uDE80 \uD83D\uDE80 \uD83D\uDE80");
//                SendMessage sendMessage = new SendMessage().setChatId(chat_id);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("                                                   !! Connect !!                                               ").setUrl(link));
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);
                    sendMessage.setReplyMarkup(markupInline);
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
//            }


//        if (update.getMessage() != null && update.getMessage().hasText()) {
//            long chat_id = update.getMessage().getChatId();
//
//
//            try {
//                execute(new SendMessage(chat_id, "Hi " + update.getMessage().getText()));
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
        }

            return null;
        }


        public void setWebHookPath (String webHookPath){
            this.webHookPath = webHookPath;
        }

        public void setBotUserName (String botUserName){
            this.botUserName = botUserName;
        }

        public void setBotToken (String botToken){
            this.botToken = botToken;
        }

    }
