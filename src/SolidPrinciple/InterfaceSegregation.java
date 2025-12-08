package SolidPrinciple;

interface Player{
    void  playAudio(String audio);
    void composeAudio(String audio);


    void playVideo();
    void videoQualityControl();
}

class AudioPlayer implements Player{

    @Override
    public void playAudio(String audio) {
        System.out.println("Playing.. " + audio);
    }

    @Override
    public void composeAudio(String audio) {
        System.out.println("Composing audio.. " + audio);
    }

    @Override
    public void playVideo() {
        System.out.println("Not supported.");
    }

    @Override
    public void videoQualityControl() {
        System.out.println("Not supported.");
    }
}
public class InterfaceSegregation {
}

interface AudioPlayerInterface{
    void playAudio(String audio);
    void composeAudio(String audio);
}

interface VideoPlayerInterface{
    void playVideo(String video);
    void videoQualityControl(String video);
}

class Video implements VideoPlayerInterface{

    @Override
    public void playVideo(String video) {

    }

    @Override
    public void videoQualityControl(String video) {

    }
}

class Multiplayer implements VideoPlayerInterface, AudioPlayerInterface{

    @Override
    public void playAudio(String audio) {

    }

    @Override
    public void composeAudio(String audio) {

    }

    @Override
    public void playVideo(String video) {

    }

    @Override
    public void videoQualityControl(String video) {

    }
}
// Class should not force to implement method which are not in used.