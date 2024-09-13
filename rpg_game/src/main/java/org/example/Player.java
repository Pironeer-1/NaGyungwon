package org.example;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private int hp; // 체력
    private int ad; // 공격력
    private int ap; // 마법력

    public Player() {
        this.hp = 50;
        this.ad = 10;
        this.ap = 5;
    }

    public int getHp() {return this.hp;}
    public int getAd() {return this.ad;}
    public int getAp() {return this.ap;}
    public void status_set(int point) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요");
        System.out.println("(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try {
                System.out.print("체력, 공격력, 마법력을 입력하세요: ");
                String input = scanner.nextLine();
                String[] inputs = input.split(" ");

                if (inputs.length != 3) {
                    throw new InputMismatchException();
                }

                int hp = Integer.parseInt(inputs[0]);
                int ad = Integer.parseInt(inputs[1]);
                int ap = Integer.parseInt(inputs[2]);

                if (hp + ad + ap == point) {
                    this.hp += hp * 3;
                    this.ad += ad;
                    this.ap += ap;
                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                }
                else {
                    System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            }
            catch (NumberFormatException e) {System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");}
            catch (InputMismatchException e) {System.out.println("hp, ad, ap를 공백을 두고 입력해주세요.");}
        }
    }

    public void decrease_hp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public void check_status(Enemy enemy){
        System.out.println("현재 유저: 체력 " + this.hp + ", 공격력 " + this.ad + ", 마법력 " + this.ap);
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAd_defence() + ", 마법방어력 " + enemy.getAp_defence() + "\n");

        int damage = this.ad - enemy.getAd_defence();
        enemy.decrease_hp(damage);
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void basicAttack(Enemy enemy) {
        Random random = new Random();
        int critical_point = random.nextInt(10) + 1;
        int damage = this.ad - enemy.getAd_defence();

        if (critical_point > 2) {
            enemy.decrease_hp(damage);
            System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
        }
        else {
            damage *= 2;
            enemy.decrease_hp(damage);
            System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
        }
    }

    public void magic_attack(Enemy enemy) {
        int damage = this.ap * 2 - enemy.getAp_defence();
        enemy.decrease_hp(damage);
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void heal_self() {
        Random random = new Random();
        int heal_point = random.nextInt(5) + 6;
        this.hp += heal_point;
        System.out.println("체력을 회복합니다. 현재 hp는 " + this.hp + "입니다.");
    }

    public void attack(Enemy enemy, int player_index) {
        String input_key = "";
        while (true){
            try{
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((player_index + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료): ");
                input_key = scanner.nextLine();

                if (input_key.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                int key_input = Integer.parseInt(input_key);
                if (key_input < 1 || key_input > 4) {
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
                    continue;
                }
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        if (input_key.equals("1")) {this.check_status(enemy);}
        else if (input_key.equals("2")) {this.basicAttack(enemy);}
        else if (input_key.equals("3")) {this.magic_attack(enemy);}
        else if (input_key.equals("4")) {this.heal_self();}
    }
}
