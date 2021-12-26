# Kroger Coupon Clipper

A Selenium automation script that downloads coupons to your Kroger Plus card. The script can only download up to the maximum amount Kroger allows to be loaded onto the card (150 coupons).

Prerequisites: Java, Maven and Google Chrome.

## Installation

1). Check what version of Chrome you have by going to Settings -> About Chrome.

2). Download the Chrome driver according to the version of Chrome you are running:
```
https://chromedriver.chromium.org/downloads
```

3). Create a folder called ChromeDriver in your C drive and place the chrome driver in it.

4). Clone the repository in Git Bash with the following command:
```
git clone https://github.com/suada-a/kroger-coupon-clipper.git
```

5). Go to the project folder:
```
cd */kroger-coupon-clipper
```
6). Replace the text 'email' and 'password' with your kroger login information, then enter the command to run the program:
```
mvn exec:java -Dexec.mainClass=org.example.KrogerCouponClipper -Dexec.args="email password"
```

## Demonstration

![kroger-coupon-clipper-demonstration](https://user-images.githubusercontent.com/36940887/147415500-4bb7974b-21cd-4742-9057-9a6767f70b95.gif)


