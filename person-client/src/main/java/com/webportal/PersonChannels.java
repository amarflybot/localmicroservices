package com.webportal;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by amarendra on 27/03/16.
 */
interface PersonChannels {

	@Output
	MessageChannel output();
}
