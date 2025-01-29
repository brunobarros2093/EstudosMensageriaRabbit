package social.bsky.bb.notificacao_service.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import social.bsky.bb.notificacao_service.entity.Pedido;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Pedido pedido) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("notificacao@email.com");
        message.setTo(pedido.emailNotificacao());
        message.setSubject("Pedido de Compra");
        message.setText(this.gerarMensagem(pedido));
        mailSender.send(message);
    }

    private String gerarMensagem(Pedido pedido) {

        String pedidoId = pedido.id().toString();
        String cliente = pedido.cliente();
        String valor = String.valueOf(pedido.valorTotal());
        String status = pedido.status().name();
        return String.format("Ola %s seu pedido de nº %s no valor de R$%s, foi realizado com sucesso\nStatus: %s",cliente,pedidoId, valor, status);

    }

}
