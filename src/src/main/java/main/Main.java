package com.github.khrysaoros.nookdbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import Marketer;

public class Main {

	public static void main(String[] args) {
		String token = "";
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		
		api.addMessageCreateListener(new MessageCreateListener() {
			public void onMessageCreate(MessageCreateEvent event) {
				String message = event.getMessageContent();
				String[] messageArray = message.split(" ", 0);
				if (messageArray[0].equalsIgnoreCase("!ping")) {
					event.getChannel().sendMessage("Pong!");
				} else if (messageArray[0].equalsIgnoreCase("!price")) {
					event.getChannel().sendMessage("Pricing for " + messageArray[1]);
					String Values = Marketer.ReadJSON(messageArray[1], messageArray[2]);
					if (Values = "") {
						event.getChannel().sendMessage('Make sure to enter the proper values! \r\n ');
					} else {
						String[] valuesArray = Values.split(">", 0);
						String[] valuesArrayArray = null;
						for (i = 0; i < valuesArray.length; i++) {
							String[] valuesArrayArray += valuesArray[i].split("<", 0);
						}
					}
				}
			}
		});
		
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
	}
}
