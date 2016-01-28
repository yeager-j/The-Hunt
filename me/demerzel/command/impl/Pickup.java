package me.demerzel.command.impl;

import me.demerzel.command.Command;
import me.demerzel.entity.EntityPlayer;
import me.demerzel.item.Item;
import me.demerzel.location.Location;
import me.demerzel.util.Game;


public class Pickup extends Command {
    @Override
    public boolean execute(String[] args) {
        EntityPlayer player = Game.getPlayer();
        Location location = player.getLocation();

        for(Item item: location.getItems()){
            if(item.getName().equalsIgnoreCase(args[1])){
                player.addItem(item);
                location.removeItem(item);
                System.out.println("You picked up the " + item.getName() + " and put it in your inventory.");
                return true;
            }
        }

        System.out.println("There's no item of that name in the current room. You must be seeing things.");
        return false;
    }
}
