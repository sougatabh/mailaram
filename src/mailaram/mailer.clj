(ns mailaram.mailer
   (:require [taoensso.timbre :as log])
  (import (java.util Properties)
          (javax.mail Message)
          (javax.mail MessagingException)
          (javax.mail PasswordAuthentication)
          (javax.mail Session)
          (javax.mail Transport)
          (javax.mail.internet InternetAddress)
          (javax.mail.internet MimeMessage)
          (javax.mail BodyPart)
          (javax.mail.internet MimeBodyPart)
          (javax.mail.internet MimeMultipart)
          (javax.activation FileDataSource)
          (javax.activation DataHandler)))



(def HTML_TYPE "text/html")

(defn get-properties
  []
  (doto (new Properties)(.put "mail.smtp.auth" "true")(.put "mail.smtp.starttls.enable" "true")
    (.put "mail.smtp.host" "smtp.gmail.com")(.put "mail.smtp.port" "587")))

(defn sendmail
     [^String to ^String from ^String subject ^String msg ^String smtpuser ^String smtppassword]
     (log/debug "Sending mail to " to ",from " from)
     (let [authenticator (proxy [javax.mail.Authenticator] []
                          (getPasswordAuthentication
                            []
                            (javax.mail.PasswordAuthentication.
                             smtpuser smtppassword)))
           properties (get-properties)
           session (javax.mail.Session/getInstance properties authenticator)
           
           message (MimeMessage. session);;Passing the session argument to the constructor
           ]
       (.setFrom  message (InternetAddress. from))
       (.setSubject message subject)
       (.setRecipients message (javax.mail.Message$RecipientType/TO) (InternetAddress/parse to))
       (.setText message  msg)
       (Transport/send message)))


(defn send-html-mail
     [^String to ^String from ^String subject ^String msg ^String smtpuser ^String smtppassword]
     (log/debug "Sending mail to " to ",from " from)
     (let [authenticator (proxy [javax.mail.Authenticator] []
                          (getPasswordAuthentication
                            []
                            (javax.mail.PasswordAuthentication.
                             smtpuser smtppassword)))
           properties (get-properties)
           session (javax.mail.Session/getInstance properties authenticator)
           
           message (MimeMessage. session);;Passing the session argument to the constructor
           ]
       (.setFrom  message (InternetAddress. from))
       (.setSubject message subject)
       (.setRecipients message (javax.mail.Message$RecipientType/TO) (InternetAddress/parse to))
       (.setContent message  msg HTML_TYPE)
       (Transport/send message)))


(defn send-mail-with-attachment
     [^String to ^String from ^String subject ^String msg ^String smtpuser ^String smtppassword ^String filename]
     (log/debug "Sending mail to " to ",from " from)
     (let [authenticator (proxy [javax.mail.Authenticator] []
                          (getPasswordAuthentication
                            []
                            (javax.mail.PasswordAuthentication.
                             smtpuser smtppassword)))
           properties (get-properties)
           session (javax.mail.Session/getInstance properties authenticator)
           message (MimeMessage. session);;Passing the session argument to the constructor
           messageBodyPart (MimeBodyPart.)
           multipart (MimeMultipart.)
           source (FileDataSource. filename)
           multifilepart (MimeBodyPart.)]
       
        (.setFrom  message (InternetAddress. from))
        (.setSubject message subject)
        (.setRecipients message (javax.mail.Message$RecipientType/TO) (InternetAddress/parse to))
        
        (.setText messageBodyPart msg)
        (.addBodyPart multipart messageBodyPart)
        
        (.setDataHandler multifilepart (DataHandler. source))
        (.setFileName multifilepart filename)
        
        (.addBodyPart multipart multifilepart)
        
        (.setContent message multipart)
        (Transport/send message)))
