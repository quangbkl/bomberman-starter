package uet.oop.bomberman.output;

public class AudioGame {
    private static String PATH_EXPLOSION = "/audios/Explosion.mp3";
    private static String PATH_BACKGROUND = "/audios/Sneaky_Snitch.mp3";
    private static String PATH_WAIT = "/audios/Spongebob_2000_Years_Later.mp3";


    private static Thread threadExplosion;
    private static Thread threadBackground;
    private static Thread threadWait;

    public static void playExplosion() {
//        if (threadExplosion == null || threadExplosion.isAlive())
        threadExplosion = new Thread(new ThreadAudio(PATH_EXPLOSION));
        threadExplosion.start();
    }

    public static void playBackground() {
        if (threadWait != null && threadWait.isAlive()) threadWait.stop();

        if (threadBackground == null) {
            threadBackground = new Thread(new ThreadAudio(PATH_BACKGROUND, true));
            threadBackground.start();
        } else {
            threadBackground.resume();
        }
    }

    public static void playWait() {
        if (threadBackground != null) threadBackground.suspend();
        if (threadExplosion != null && threadExplosion.isAlive()) threadExplosion.stop();

        if (threadWait == null || !threadWait.isAlive()) {
            threadWait = new Thread(new ThreadAudio(PATH_WAIT));
            threadWait.start();
        }
    }

    public static void stopAllAudio(Thread ...notStop) {
        if (threadBackground != null) threadBackground.suspend();
        if (threadWait != null && threadWait.isAlive()) threadWait.stop();
        if (threadExplosion != null && threadExplosion.isAlive()) threadExplosion.suspend();

    }
}
