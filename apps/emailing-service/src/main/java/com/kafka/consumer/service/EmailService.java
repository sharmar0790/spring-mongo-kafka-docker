package com.kafka.consumer.service;

import com.kafka.consumer.model.BookingRequest;
import com.kafka.consumer.model.RemovedBookingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender emailSender;


    public void sendEmail(final BookingRequest request) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom("do-not-reply@gmail.com");
            messageHelper.setReplyTo("do-not-reply@gmail.com");
            messageHelper.setTo(request.getEmail());
            messageHelper.setSubject("Booking Success");
            messageHelper.setText("Hi " + request.getName() + ",\n \n Your booking has been successfully booked and your reference Id is : " + request.getReferenceId() + "." +
                    "\n \n \n \n \n \n **********  This is a system generated email. Please do not reply to this email.*************");
        };
        emailSender.send(messagePreparator);
    }


    public void sendEmail(final RemovedBookingMessage msg) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom("do-not-reply@gmail.com");
            messageHelper.setReplyTo("do-not-reply@gmail.com");
            messageHelper.setTo(msg.getEmail());
            messageHelper.setSubject("Booking Cancelled");
            messageHelper.setText("Hi " + msg.getName() + ",\n \n Your booking has been successfully cancelled for reference Id : " + msg.getReferenceId() + "." +
                    "\n \n \n \n \n \n **********  This is a system generated email. Please do not reply to this email.*************");
        };
        emailSender.send(messagePreparator);
    }
}
