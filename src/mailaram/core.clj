(ns mailaram.core
  (:require [taoensso.timbre :as log]
            [mailaram.mailer :as mailer]))

(defn sendmail
  "This is to send mail to certain email, address using gmail"
  [^String to ^String from ^String subject ^String msg ^String smtpusername ^String smtppassword]
  (try(mailer/sendmail to from subject msg smtpusername smtppassword)
    (log/debug "Mail-sent Successfully!!!!!!!!!")
    true
     (catch Exception e
   
      (log/error e (str "Error sending email to " to))
      nil)))

(defn send-html-mail
  "This is to send mail to certain email, address using gmail"
  [^String to ^String from ^String subject ^String msg ^String smtpusername ^String smtppassword]
  (try(mailer/send-html-mail to from subject msg smtpusername smtppassword)
    (log/debug "Mail-sent Successfully!!!!!!!!!")
    true
     (catch Exception e
   
      (log/error e (str "Error sending email to " to))
      nil)))


(defn send-mail-with-attachment
  "This is to send mail to certain email, address using gmail"
  [^String to ^String from ^String subject ^String msg ^String smtpusername ^String smtppassword ^String filename]
  (try(mailer/send-mail-with-attachment to from subject msg smtpusername smtppassword filename)
    (log/debug "Mail-sent Successfully!!!!!!!!!")
    true
     (catch Exception e
   
      (log/error e (str "Error sending email to " to))
      nil)))

