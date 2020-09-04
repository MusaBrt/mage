package mage.cards.m;

import mage.MageInt;
import mage.abilities.common.SpellCastControllerTriggeredAbility;
import mage.abilities.effects.keyword.ScryEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.FilterSpell;
import mage.filter.predicate.mageobject.KickedPredicate;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class MerfolkFalconer extends CardImpl {

    private static final FilterSpell filter = new FilterSpell("a kicked spell");

    static {
        filter.add(KickedPredicate.instance);
    }

    public MerfolkFalconer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{U}{U}");

        this.subtype.add(SubType.MERFOLK);
        this.subtype.add(SubType.WIZARD);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);

        // Flying
        this.addAbility(FlyingAbility.getInstance());

        // Whenever you cast a kicked spell, scry 2.
        this.addAbility(new SpellCastControllerTriggeredAbility(new ScryEffect(2), filter, false));
    }

    private MerfolkFalconer(final MerfolkFalconer card) {
        super(card);
    }

    @Override
    public MerfolkFalconer copy() {
        return new MerfolkFalconer(this);
    }
}
