In this sample project I provide a functioning soultion for sending firebase cloud messages (FCM) from <b>device to device</b>. This is limited for users using your app for obvious reasons (delivering an FCM needs a recepient token).

The project consists of 3 main branch:
<ul>
<li>Receiving a notificaton - this is basically a notification builder part, so the user will be able to receive an FCM (find in the <a href="app/src/main/java/com/foldrajzappok/fcminjetpackcompose/assistance/receiveNotification">receiveNotification</a> folder)/</li>
  <li>Sending a notification - this is where you call a hosted function which will communicate with the FCM service (find in the <a href="app/src/main/java/com/foldrajzappok/fcminjetpackcompose/assistance/sendNotification">sendNotification</a>)</li>
  <li>Hosting a message sending function - this message sending function supposed to be placed on a public server and the function must be able to communicate with FCM (find in the <a href="app/src/main/java/com/foldrajzappok/fcminjetpackcompose/NOT_HERE">NOT HERE</a> folder)</li>
</ul>

There are great tutorials explaining how to send targeted FCM messages to users, but it is hard to find a current explanation of <b>how users can notify each other</b> like in Messenger or WhatsApp. 

<i><b>The key concept is</b> that FCM service finds users using a special token, and most importantly your app can not call FCM directly anymore (security reasons). There must be a hosted function which is integrated with Firebase Admin SDK. You can not integrate Firebase Admin SDK to your app directly, therefore the need of the hosted function.</i>

At the point where you try to integrate FCM to your app you probably already connected your app to Firebase, so there is no need to explain this here.

Check the gradle files to see the necesseary dependencies.


