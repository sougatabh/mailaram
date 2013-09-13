# mailaram

A clojure library to send mail using gmail smtp server

## Usage

On Clojars: https://clojars.org/mailaram

Leiningen dependency: `[mailaram "0.1.0"]`

Supported Clojure versions:  1.4, 1.5

`[mailaram.core        :as mailaram]`

### For sending mail
`(sendmail to from subject message smtpusername smtppassword)`

###For sending HTML mail
`(send-html-mail to from subject message smtpusername smtppassword)`
###For sending Mail with attachment
`(send-html-mail to from subject message smtpusername smtppassword fileFullpath)`


## Getting in touch

By e-mail: sougata(at)gmail.com

On Twitter: [@sougata](http://twitter.com/sougatabh)

## License

Copyright © 2013 Sougata Bhattacharya

Distributed under the Eclipse Public License, the same as Clojure.
