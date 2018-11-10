package uet.oop.bomberman.output;

public class AudioGame {
    private static String PATH_EXPLOSION = "/audios/Explosion.mp3";
    private static String PATH_BACKGROUND = "/audios/Sneaky_Snitch.mp3";
    private static String PATH_WAIT = "/audios/Spongebob_2000_Years_Later.mp3";
    private static String PATH_GAME_OVER = "/audios/Sad_Violin.mp3";
    private static String PATH_DEATH = "/audios/The_Price_is_Right_Losing_Horn.mp3";

    private static Thread threadExplosion;
    private static Thread threadBackground;
    private static Thread threadWait;
    private static Thread threadGameOver;
    private static Thread threadDeath;

    public static void playExplosion() {
        threadExplosion = new Thread(new ThreadAudio(PATH_EXPLOSION));
        threadExplosion.start();
    }

    public static void playDeath() {
        threadDeath = new Thread(new ThreadAudio(PATH_DEATH));
        threadDeath.start();
    }

    public static void playBackground() {
        stopAudioBackground(threadBackground);

        if (threadBackground == null || !threadBackground.isAlive()) {
            threadBackground = new Thread(new ThreadAudio(PATH_BACKGROUND, true));
            threadBackground.start();
        } else {
            threadBackground.resume();
        }
    }

    public static void playWait() {
        stopAudioBackground(threadWait);

        if (threadWait == null || !threadWait.isAlive()) {
            threadWait = new Thread(new ThreadAudio(PATH_WAIT));
            threadWait.start();
        }
    }

    public static void playGameOver() {
        stopAudioBackground(threadGameOver);

        if (threadGameOver == null || !threadGameOver.isAlive()) {
            threadGameOver = new Thread(new ThreadAudio(PATH_GAME_OVER));
            threadGameOver.start();
        }
    }

    private static boolean hasThread(Thread thread, Thread[] threads) {
        for (Thread temp : threads) {
            if (thread == temp) return true;
        }

        return false;
    }

    public static void stopAudioBackground(Thread... notStop) {
        if (threadWait != null && threadWait.isAlive() && !hasThread(threadWait, notStop))
            threadWait.stop();
        if (threadBackground != null && threadBackground.isAlive() && !hasThread(threadBackground, notStop))
            threadBackground.stop();
        if (threadGameOver != null && threadGameOver.isAlive() && !hasThread(threadGameOver, notStop))
            threadGameOver.stop();
    }

    public static void stopAudioEffect(Thread... notStop) {
        if (threadDeath != null && !threadDeath.isAlive())
            threadDeath.stop();
        if (threadExplosion != null && !threadExplosion.isAlive())
            threadExplosion.stop();
    }

    public static void suspendAudioEffect(Thread... notSuspend) {
        if (threadDeath != null)
            threadDeath.suspend();
        if (threadExplosion != null)
            threadExplosion.suspend();
    }

    public static void resumeAudioEffect(Thread... notSuspend) {
        if (threadDeath != null)
            threadDeath.resume();
        if (threadExplosion != null)
            threadExplosion.resume();
    }

    public static void stopAllAudio(Thread... notStop) {
        stopAudioBackground(notStop);
        stopAudioEffect(notStop);
    }
}
