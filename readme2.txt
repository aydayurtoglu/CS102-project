Group number: g2E
Title: Momentum
Description: An animation app that makes creating stop motion animation easier!
Current status: Uncompleted

The app can create an animation project. It has a camera implemented in it and with
the camera, the user can capture images and store them in an internal storage file.
But we couldn't retrieve those images from the file and instead used default images
that are stored in R.drawable file. The app shows these images in an image gallery
and allows the user to draw on them. However, there is only one color for the brush
and the new image with drawings on it is not saved within the image gallery. Still,
the images in the gallery can be used to create an animation of them. The user can
adjust the speed of the animation and play it repeatedly by clicking on the project.
But the project can't be saved as a video, it can only be seen as an animation 
within the app.

The storage problem should be fixed and some minor adjustments to the DrawActivity
can be made. We should make animation as a video that can be saved. We should use
a database to allow the app to create more than one project at a time. The creating
and adding stickers to the images and adding sound files to the project should be 
added.

What we have worked on:

Ayda: I worked on creating multiple projects at the same time at first, it didn't
work. I created my own UML diagram and combined the others, but it changed over time.
Can and I teamed up to design the overall view of the app. We wrote AutoImageSlider
class and did research on how we can create animation with images together. I helped
to the construction of the camera a bit. I wrote ImageAdapter class, Fullscreen
Activity and ImageGallery Activity. We adjusted the ImageAdapter class with the other
group members. I did research on the storage of images a lot. I finalized some of 
the reports, the code and the UML diagram. 

Beste: I wrote the code for the camera activity of our project. I managed to do this by
working with Ece. In order to implement it we made research on the websites like "Android 
developers". These pages were quite helpful. We implemented two cameras for our application.
The very first camera we used was the camera of Android Studio. It was working fine but the
quality of it was not very good. So by doing more research we needed to rewrite a new camera.
Now, in our project we are using the last camera. Ece and I also worked on classes like Project and Video
to create a MVC pattern in our project. We planned to use Project class as our model but when we further
progressed in our project we realized that it is really hard to create MVC in android studio.
I also write the code for storing the captured images by camera. Now, the pictures taken by camera can be 
stored in the storage of mobile phones. However, Ece and I tried to get this data from storage but we 
couldn't do it.

Can: First, I prepared the slideshow and logo for describing and present the program in front 
of CS102 students. We presented it with Ayda. Then I made some design for the interface of 
application and we tried the follow it. When we have the design, we discussed how our classes
should be and tried to write our codes. I wrote the About Momentum class which describes what 
is Momentum and what we provide users in this program. Also, Ayda and me wrote the AutoImageSlider 
class. My research helped us a lot while we are trying the change the speed of the animation. 
We have done that successfully, it is working properly and the user now be able to change the
animation's speed and play it over and over. The activity looks and works like a video player. 
Then, I worked for the ImageAdapter class with some of group members. Finally, I wanted all 
members topk a clip for the video, then I combined and edited the clips to make a video. 

Eren:

Ata: Eren and I wrote the DrawActivity class and its activity. I was also responsible
from meeting logs about what we discussed and decided to do until next meeting. Other than these,
I researched a lot about mechanics of Android Studio and features that we used in other classes
such as using camera, storage and creating animation and helped my friends a little to write other 
classes. Finally, I made minor changes on designs and order of activities.


Ece: I worked on implementing the camera in our app with Beste. We first tried using
the camera of the Android Studio but then we have decided to use another camera because
the quality of the first camera was not as good as we have wanted it to be. I helped 
writing the UML diagram, and the help page for our app. Beste and I wrote the video and photos
classes but we ended up not using them because we found better solutions. Beste and I also
did researches and worked on multiple ways of trying to get our data from the internal storage
but it did not work out.

We used latest version, 3.6.3, of Android Studio for our project, developed by Google and JetBrains, built on 
JetBrains' IntelliJ IDEA software which is another IDE and designed specifically for Android development.
We used classic Java libraries that we used in CS101 & 102 and Android libraries which brought by Android Studio and
allowed us to create designs, use hardwares of a smartphone and run the project as an app on Android OS.
Our project, or app to be precise, can work on any Android OS. For example, you can use an  Android emulator which
is basically a smartphone in your PC or you can connect your Android phone to your PC as the platform for the app.
When you have the platform to run the app, you can compile, setup and run the app from Android Studio and use it as a regular app.

