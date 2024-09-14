package org.example;
import java.util.Random;

public class Enemy {
    private int max_hp;
    private int hp;
    private int ad;
    private int ad_defence;
    private int ap_defence;

    public Enemy(int list_num) {
        this.max_hp = list_num * 100;
        this.hp = list_num * 100;
        this.ad = 25;
        this.ad_defence = 7;
        this.ap_defence = 7;
    }


    public int getMax_hp() {return max_hp;}
    public int getHp() {return hp;}
    public int getAd() {return ad;}
    public int getAd_defence() {return ad_defence;}
    public int getAp_defence() {return ap_defence;}

    public void decrease_hp(int damage) {this.hp = Math.max(this.hp - damage, 0);}
    public void basic_attack(Player player, int player_index) {
        player.decrease_hp(this.ad);
        System.out.println((player_index + 1) + "번 유저에게 " + this.ad + "의 데미지. 적의 공격으로 현재 남은 체력은 " + player.getHp() + "입니다.");
    }
    public void heal_self() {
        int healing_amount = 7;
        if (this.max_hp < (this.hp + healing_amount)) {
            this.hp = this.max_hp;
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.");
        }
        else {
            this.hp += healing_amount;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + "입니다.");
        }
    }

    public void attack(Player player, int player_index) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.");

        Random random = new Random();
        int enemy_action = random.nextInt(10) + 1;

        if(enemy_action == 1){
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
        }
        else if (enemy_action >= 2 && enemy_action <= 8) {
            basic_attack(player, player_index);
        }
        else { heal_self();}
    }
}
