package ocgcore.enums;

public enum GameMessage {
    Retry(1),
    Hint(2),
    Waiting(3),
    Start(4),
    Win(5),
    UpdateData(6),
    UpdateCard(7),
    RequestDeck(8),
    SelectBattleCmd(10),
    SelectIdleCmd(11),
    SelectEffectYn(12),
    SelectYesNo(13),
    SelectOption(14),
    SelectCard(15),
    SelectChain(16),
    SelectPlace(18),
    SelectPosition(19),
    SelectTribute(20),
    SortChain(21),
    SelectCounter(22),
    SelectSum(23),
    SelectDisfield(24),
    SortCard(25),
    ConfirmDecktop(30),
    ConfirmCards(31),
    ShuffleDeck(32),
    ShuffleHand(33),
    RefreshDeck(34),
    SwapGraveDeck(35),
    ShuffleSetCard(36),
    ReverseDeck(37),
    DeckTop(38),
    NewTurn(40),
    NewPhase(41),
    Move(50),
    PosChange(53),
    Set(54),
    Swap(55),
    FieldDisabled(56),
    Summoning(60),
    Summoned(61),
    SpSummoning(62),
    SpSummoned(63),
    FlipSummoning(64),
    FlipSummoned(65),
    Chaining(70),
    Chained(71),
    ChainSolving(72),
    ChainSolved(73),
    ChainEnd(74),
    ChainNegated(75),
    ChainDisabled(76),
    CardSelected(80),
    RandomSelected(81),
    BecomeTarget(83),
    Draw(90),
    Damage(91),
    Recover(92),
    Equip(93),
    LpUpdate(94),
    Unequip(95),
    CardTarget(96),
    CancelTarget(97),
    PayLpCost(100),
    AddCounter(101),
    RemoveCounter(102),
    Attack(110),
    Battle(111),
    AttackDiabled(112),
    DamageStepStart(113),
    DamageStepEnd(114),
    MissedEffect(120),
    BeChainTarget(121),
    CreateRelation(122),
    ReleaseRelation(123),
    TossCoin(130),
    TossDice(131),
    AnnounceRace(140),
    AnnounceAttrib(141),
    AnnounceCard(142),
    AnnounceNumber(143),
    CardHint(160),
    TagSwap(161),
    ReloadField(162),
    AiName(163),
    ShowHint(164),
    MatchKill(170),
    CustomMsg(180),
    DuelWinner(200);

    private int value = 0;

    GameMessage(int value) {
        this.value = value;
    }

    public static GameMessage valueOf(int value) {
        GameMessage[] attributes = GameMessage.values();
        for (GameMessage attribute : attributes) {
            if (attribute.value() == value) {
                return attribute;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
