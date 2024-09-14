package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int status_point;
    private int list_num;
    private Enemy enemy;
    private List<Player> player_list = new ArrayList<>();

    public void set_players() {
        Scanner scanner = new Scanner(System.in);
        int players;
        while (true) {
            try {
                System.out.print("플레이어 인원을 정하세요: ");
                players = Integer.parseInt(scanner.nextLine());

                if (players <= 0) {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                    continue;
                }
                this.list_num = players;
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        for (int i = 0; i < this.list_num; i++) {
            Player player = new Player();
            player.status_set(this.status_point);
            this.player_list.add(player);
        }
    }

    public void set_enemy() {
        this.enemy = new Enemy(player_list.size());
    }

    public boolean turn_check() {
        player_list.removeIf(player -> player.getHp() <= 0);

        if (player_list.isEmpty()) {return false;}
        else {return true;}
    }

    public Player select_target_player() {
        Random random = new Random();
        int index = random.nextInt(player_list.size());
        return player_list.get(index);
    }

    public Game() {
        this.status_point = 13;
        set_players();
        set_enemy();

        while (this.turn_check()) {
            for (int player_idx = 0; player_idx < this.player_list.size(); player_idx++) {
                Player player = this.player_list.get(player_idx);
                player.attack(this.enemy, player_idx);

                if (enemy.getHp() == 0){break;}
            }

            if(this.turn_check()){
                Player target_player = this.select_target_player();
                int target_index = player_list.indexOf(target_player);

                this.enemy.attack(target_player, target_index);
            }
            else {
                break;
            }
        }

        if (enemy.getHp() <= 0) { System.out.println("축하합니다! 승리하셨습니다!");}
        else {System.out.println("아쉽지만 패배하셨습니다.");};
    }
}
