--[[message
更新：2023-03-26
卡数：19
规则：大师3
]]
Debug.SetAIName("棉花")
Debug.ReloadFieldBegin(DUEL_ATTACK_FIRST_TURN+DUEL_SIMPLE_AI,3)
Debug.SetPlayerInfo(0,100,0,0)
Debug.SetPlayerInfo(1,13400,0,0)

Debug.AddCard(18282103,0,0,LOCATION_DECK,0,POS_FACEUP_ATTACK)
Debug.AddCard(82888408,0,0,LOCATION_DECK,0,POS_FACEUP_ATTACK)
Debug.AddCard(97439806,0,0,LOCATION_DECK,0,POS_FACEUP_ATTACK)
Debug.AddCard(97439806,0,0,LOCATION_GRAVE,0,POS_FACEUP_ATTACK)
Debug.AddCard(57421866,0,0,LOCATION_GRAVE,0,POS_FACEUP_ATTACK)
Debug.AddCard(44155002,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(39477584,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(54048462,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(47395382,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(76774528,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(76774528,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(76774528,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(12014404,0,0,LOCATION_EXTRA,0,POS_FACEDOWN_ATTACK)
Debug.AddCard(72328962,0,0,LOCATION_HAND,1,POS_FACEUP_ATTACK)
Debug.AddCard(19439119,0,0,LOCATION_HAND,2,POS_FACEUP_ATTACK)
Debug.AddCard(82888408,0,0,LOCATION_HAND,3,POS_FACEUP_ATTACK)
Debug.AddCard(24040093,0,0,LOCATION_HAND,4,POS_FACEUP_ATTACK)
Debug.AddCard(18282103,0,0,LOCATION_HAND,5,POS_FACEUP_ATTACK)
local m10=Debug.AddCard(89631139,1,1,LOCATION_MZONE,1,POS_FACEUP_ATTACK)
local e10=Effect.CreateEffect(m10)
e10:SetType(EFFECT_TYPE_SINGLE)
e10:SetCode(EFFECT_UPDATE_ATTACK)
e10:SetValue(500)
e10:SetReset(RESET_EVENT+RESETS_STANDARD)
m10:RegisterEffect(e10)
local m11=Debug.AddCard(89631139,1,1,LOCATION_MZONE,2,POS_FACEUP_ATTACK)
local e11=Effect.CreateEffect(m10)
e11:SetType(EFFECT_TYPE_SINGLE)
e11:SetCode(EFFECT_UPDATE_ATTACK)
e11:SetValue(500)
e11:SetReset(RESET_EVENT+RESETS_STANDARD)
m11:RegisterEffect(e11)
local m12=Debug.AddCard(89631139,1,1,LOCATION_MZONE,3,POS_FACEUP_ATTACK)
local e12=Effect.CreateEffect(m10)
e12:SetType(EFFECT_TYPE_SINGLE)
e12:SetCode(EFFECT_UPDATE_ATTACK)
e12:SetValue(500)
e12:SetReset(RESET_EVENT+RESETS_STANDARD)
m12:RegisterEffect(e12)
Debug.AddCard(19665973,1,1,LOCATION_HAND,3,POS_FACEUP_ATTACK)
Debug.AddCard(89631139,1,1,LOCATION_HAND,4,POS_FACEUP_ATTACK)


Debug.ReloadFieldEnd()
aux.BeginPuzzle()
Debug.ShowHint("少数怪兽攻击力已改变。")



local e1=Effect.GlobalEffect()
e1:SetType(EFFECT_TYPE_FIELD+EFFECT_TYPE_CONTINUOUS)
e1:SetCode(EVENT_PHASE_START+PHASE_END)
e1:SetCondition(function(e,tp,eg,ep,ev,re,r,rp) return Duel.GetTurnPlayer()==0 end)
e1:SetOperation(function(e,tp,eg,ep,ev,re,r,rp)
Debug.ShowHint("提示：等级偷窃虫") end)
Duel.RegisterEffect(e1,0)
