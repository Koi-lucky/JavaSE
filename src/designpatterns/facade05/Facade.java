package designpatterns.facade05;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/12 9:50
 */
public class Facade {
    private MovieEquipment movieEquipment = new MovieEquipment();

    // 观影的前期准备
    public void watchingMovie() {
        movieEquipment.turnOnTV();
        movieEquipment.setCD();
        movieEquipment.startWatching();
    }
}
