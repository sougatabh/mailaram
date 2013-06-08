# mailaram
This is a simple mail library to send mail using gmail smtp service.

## Usage

## For Sending Simple mail
sendmail("to@gmail.com" "from@gmail.com" "My Email Subject" "Email Body" "smtpusername@gmail.com" "smtpse3ret")

## For Sending HTML mail
send-html-mail("to@gmail.com" "from@gmail.com" "My Email Subject" "<html><body>Email Body</body></html>" "smtpusername@gmail.com" "smtpse3ret")

## For Sending mail with attachment
send-mail-with-attachment("to@gmail.com" "from@gmail.com" "My Email Subject" "Email Body" "smtpusername@gmail.com" "smtpse3ret" "/home/user/attachment.txt")


## License

Copyright © 2013 Sougata Bhattacharya

Distributed under the Eclipse Public License, the same as Clojure.
