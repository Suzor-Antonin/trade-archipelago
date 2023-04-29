package events;

import mechanics.*;

public class EventLists_
{
    public Game_ game;

    public EventLists_(Game_ game)
    {
        this.game = game;
    }

    public Event_ Global(int seed)
    {
        switch (seed % 3)
        {
            case 0:
                return new Event_("Gracious gift !",
                        new String[]{
                                "A generous noble has acknowledged your potential and wantsfor you to thrive.",
                                "As a result, they are giving you financial aid for your projects."
                        },
                        'G',
                        new Resources_[]{
                                new Resources_(),
                                new Resources_(100, 0, 0, 0)
                        },
                        new String[]{
                                "Deny the gift",
                                "Accept the gift"
                        });

            case 1:
                return new Event_("Fish storage blight",
                        new String[]{
                                "A sickness has spread in our fish storage !",
                                "Luckily, our men were able to spot it early, so it won't spread to the populace.",
                                "Still, it is disheartening to have to throw away such measures of food for our people."
                        },
                        'G',
                        new Resources_[]{
                                new Resources_(0, (game.resources.food <= 100 ? -game.resources.food : -100), 0, 0),
                                new Resources_(-50, (game.resources.food <= 70 ? -game.resources.food : -70), 0, 0)
                        },
                        new String[]{
                                "Deal with it",
                                "Try to salvage"
                        });

            case 2:
                return new Event_("Kingdom war effort",
                        new String[]{
                                "The kingdom you belong to has entered war, yet again.",
                                "As such, you are expected to contribute in some way.",
                                "This war does not truly concern you. Send what you need less."
                        },
                        'G',
                        new Resources_[]{
                                new Resources_(0, 0, -70, -70),
                                new Resources_(0, -150, 0, 0),
                                new Resources_(-100, 0, 0, 0),
                                new Resources_(-30, -50, -20, -20)
                        },
                        new String[]{
                                "Send materials",
                                "Send fish",
                                "Send gold",
                                "Send various resources"
                        });

            default:
                return null;
        }
    }

    public Event_ Local(int seed)
    {
        switch (seed % 4)
        {
            case 0:
                return new Event_("Shipwreck Survivor",
                        new String[]{
                                "A man washes ashore on your island.",
                                "He claims to be a survivor from a shipwreck, and has evidence to back it up.",
                                "We could welcome him and employ him, but do we want to trust him ?"
                        },
                        'L',
                        new Resources_[]{
                                new Resources_(1, 0, 0, 0, 0),
                                new Resources_()
                        },
                        new String[]{
                                "Welcome him",
                                "Put him on a ship"
                        });

            case 1:
                return new Event_("Shipwreck Survivors",
                        new String[]{
                                "A raft comes to your island. Several people appear cramped on it.",
                                "They say they are from a merchant ship that wrecked on its way the Archipelago.",
                                "They will accept to stay, yet they offer you coin should you send them back on a ship.",
                                "What shall be done with them ?"
                        },
                        'L',
                        new Resources_[]{
                                new Resources_(9, 0, 0, 0, 0),
                                new Resources_(34, 0, 0, 0, 0)
                        },
                        new String[]{
                                "Welcome them",
                                "Send them back"
                        });
            case 2:
                return new Event_("Cruel pirates",
                        new String[]{
                                "A ship with a black flag comes to your island, blocking off your naval activities.",
                                "A few of its crew come to shore, asking you to pay a \"toll\", lest they murder you people.",
                                "The few bystanders able to fight look to the ground, not wanting to interfere."
                        },
                        'L',
                        new Resources_[]{
                                new Resources_(-50, 0, 0, 0),
                                new Resources_(-4, 0, 0, 0, 0)
                        },
                        new String[]{
                                "Accept",
                                "Refuse",
                        });
            case 3:
                return new Event_("Unusually large haul",
                        new String[]{
                                "As the morning comes, hubbub is gathering on the fishing pier.",
                                "Some of your fishermen have gone deeper into the ocean at night, catching way more fish.",
                                "Sadly, one of them died due to risky maneuvers.",
                                "Their death will not be in vain, as the extra fish will feed the people well."
                        },
                        'G',
                        new Resources_[]{
                                new Resources_(-1, 0, 70, 0, 0)
                        },
                        new String[]{
                                "Store the fish"
                        });
            default:
                return null;
        }
    }

    public Event_ Ship(int seed)
    {
        switch (seed % 4)
        {
            case 0:
                return new Event_("Ship of settlers",
                        new String[]{
                                "A ship comes to your island, bearing a few families.",
                                "They have heard of your just rule and have traveled the seas to settle on your island.",
                                "To deny them land would be cruel, but we need to make sure that we can feed them too..."
                        },
                        'S',
                        new Resources_[]{
                                new Resources_(),
                                new Resources_(20, 0, 0, 0, 0)
                        },
                        new String[]{
                                "Refuse them",
                                "Welcome them"
                        });

            case 1:
                return new Event_("Stone trading ship",
                        new String[]{
                                "Arriving at your island is a ship loaded with various types of stones.",
                                "Some rough, some cut and ready to be utilised in construction, some oddly shaped...",
                                "They are offering you to part with some of it, in exchange of a price, of course."
                        },
                        'S',
                        new Resources_[]{
                                new Resources_(-40, 0, 0, 100),
                                new Resources_(-20, 0, 0, 40),
                                new Resources_()
                        },
                        new String[]{
                                "Buy a lot of stone",
                                "Buy some stone",
                                "Do nothing"
                        });

            case 2:
                return new Event_("Slave merchants",
                        new String[]{
                                "This ship bears people in it. The captain refers to them as \"convicts to sale\".",
                                "But you know that they are slaves. You could engage in their business to gain a few hands.",
                                "Or, you could rack up some quick cash, at the expanse of your good sleep."
                        },
                        'S',
                        new Resources_[]{
                                new Resources_(10, -120, 0, 0, 0),
                                new Resources_(-10, 100, 0, 0, 0),
                                new Resources_()
                        },
                        new String[]{
                                "Liberate some",
                                "Give away some",
                                "Do nothing"
                        });

            case 3:
                return new Event_("Seafaring meatery",
                        new String[]{
                                "The scent of meat comes to your nostrils as you come to inspect this ship.",
                                "The crew explains that they stock up on meats to sell on the seas.",
                                "Such food is a rarity in this archipelago where fish is served for every meal.",
                                "But your personal reserves do contain some..."
                        },
                        'S',
                        new Resources_[]{
                                new Resources_(-75, 200, 0, 0),
                                new Resources_(-20, 60, 0, 0),
                                new Resources_(5, -20, 0, 0),
                                new Resources_()
                        },
                        new String[]{
                                "Buy out their stock",
                                "Buy reasonably",
                                "Sell meat you own",
                                "Do nothing"
                        });
            default:
                return null;
        }
    }
    /*

            case 1:
                return new Event_("",
                        new String[]{
                                ""
                        },
                        'G',
                        new Resources_[]{
                                new Resources_(),
                                new Resources_()
                        },
                        new String[]{
                                "",
                                ""
                });
    */

    public Event_ taxOk()
    {
        return new Event_("Yearly tax !",
                new String[]{
                        "An envoy of the kingdom has come to reap the heavy yearly tax.",
                        "\"You know what you owe us. I ask that you hand it over to me.\", he says, grinning.",
                        "\"Otherwise, we'll have to send the navy to retake control of the archipelago.\"",
                        "Reluctantly, you pay the tax, and bide your time. Another year begins."
                },
                'G',
                new Resources_[]{
                        new Resources_(-(game.taxBase + (game.nbIslandsOwned) * game.taxExtra), 0, 0, 0)
                },
                new String[]{
                        "A new year begins..."
                });
    }
    public Event_ taxSC()
    {
        return new Event_("Yearly tax !",
                new String[]{
                        "An envoy of the kingdom has come to reap the heavy yearly tax.",
                        "\"What ? You do not have enough to pay your taxes for this year ? How dare you !\", he spouts.",
                        "\"Fine. We will not send the army this time. However, you will give us everything you have !\"",
                        "Left without a choice, you accept his deal. Next time, there will be no second chance."
                },
                'G',
                new Resources_[]{
                        new Resources_(-(game.resources.gold + game.income.gold),
                                -(game.resources.food + game.income.food),
                                -(game.resources.wood + game.income.wood),
                                -(game.resources.stone + game.income.stone))
                },
                new String[]{
                        "A new year begins..."
                });
    }
    public Event_ taxNope()
    {
        return new Event_("Yearly tax !",
                new String[]{
                        "An envoy of the kingdom has come to reap the heavy yearly tax.",
                        "You try to weave your way with them, yet they are no fool, and leave the archipelago at once.",
                        "Soon, the navy of the kingdom will come here to reclaim the islands as theirs."
                },
                'G',
                new Resources_[]{
                        new Resources_()
                },
                new String[]{
                        "No hope is left"
                });
    }

    public Event_ independence()
    {
        return new Event_("Buying the independence",
                new String[]{
                        "At last, you have gathered the required sum.",
                        "The 16,000 gold needed for you to buy your independence from the kingdom.",
                        "It feels weirdly fulfilling to part with all of this money."
                },
                'G',
                new Resources_[]{
                        new Resources_(-16000, 0, 0, 0)
                },
                new String[]{
                        "Buy the independence"
                });
    }
}
