--[[message 融合召唤入门]]
Debug.SetAIName("高性能电子头脑")
Debug.ReloadFieldBegin(DUEL_ATTACK_FIRST_TURN+DUEL_SIMPLE_AI,5)
Debug.SetPlayerInfo(0,1000,0,0)
Debug.SetPlayerInfo(1,5400,0,0)

Debug.AddCard(45906428,0,0,LOCATION_HAND,0,POS_FACEDOWN)
Debug.AddCard(21143940,0,0,LOCATION_HAND,0,POS_FACEDOWN)
Debug.AddCard(24094653,0,0,LOCATION_HAND,0,POS_FACEDOWN)
Debug.AddCard(00213326,0,0,LOCATION_HAND,0,POS_FACEDOWN)

Debug.AddCard(40044918,0,0,LOCATION_DECK,1,POS_FACEUP_ATTACK)
Debug.AddCard(37195861,0,0,LOCATION_DECK,2,POS_FACEUP_ATTACK)

Debug.AddCard(03642509,0,0,LOCATION_EXTRA,0,POS_FACEDOWN)
Debug.AddCard(29095552,0,0,LOCATION_EXTRA,1,POS_FACEDOWN)
Debug.AddCard(40854197,0,0,LOCATION_EXTRA,2,POS_FACEDOWN)

Debug.AddCard(09348522,1,1,LOCATION_MZONE,1,POS_FACEUP_DEFENCE)
Debug.AddCard(32012841,1,1,LOCATION_MZONE,2,POS_FACEUP_DEFENCE)
Debug.AddCard(31305911,1,1,LOCATION_MZONE,3,POS_FACEUP_DEFENCE)

Debug.AddCard(62279055,1,1,LOCATION_SZONE,2,POS_FACEDOWN)

Debug.ReloadFieldEnd()
Debug.ShowHint("GAME START!")
aux.BeginPuzzle()
