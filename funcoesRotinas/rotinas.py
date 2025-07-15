import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

def enviar_email(destinatario, assunto, mensagem):
    msg = MIMEMultipart()
    msg['From'] = 'josephcavalcante.dev@gmail.com'
    msg['To'] = destinatario
    msg['Subject'] = assunto
    msg.attach(MIMEText(mensagem, 'plain'))
    servidor = smtplib.SMTP('smtp.gmail.com', 587)
    servidor.starttls()
    servidor.login(msg['From'], 'orrxoobtxsdzlyfb')
    texto = msg.as_string()
    servidor.sendmail(msg['From'], msg['To'], texto)
    servidor.quit()

enviar_email('josephcavalcante99@gmail.com', 'Teste', 'Olá, este é um teste.')
print('E-mail enviado com sucesso!')