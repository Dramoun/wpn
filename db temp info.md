https://www.drawdb.app/editor/diagrams



Table player [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
name text(65535) [ not null ]
shortName text(65535) [ not null ]
joinedAt datetime [ not null ]
lastPlayedAt datetime [ not null ]
totalGames integer [ not null ]
totalWins integer [ not null ]
averageScore integer [ not null ]
highScore integer [ not null ]
lowScore integer [ not null ]
}

Table match [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
playedAt datetime [ not null ]
hardScoring boolean [ not null ]
}

Table playerMatch [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
playerId integer [ not null ]
matchId integer [ not null ]
totalBirdScore integer [ not null ]
totalEggCount integer [ not null ]
totalGatheredFood integer [ not null ]
totalTuckedCards integer [ not null ]
totalBirdCount integer [ not null ]
totalPersonalQuests integer [ not null ]
totalMatchQuests integer [ not null ]
}

Table dlcTable [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
name text(65535) [ not null ]
description text(65535) [ not null ]
}

Table tagsTable [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
name text(65535) [ not null ]
description text(65535) [ not null ]
}

Table personalQuestsTable [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
name text(65535) [ not null ]
description text(65535) [ not null ]
}

Table matchQuestsTable [headercolor: #175e7a] {
id integer [ pk, increment, not null, unique ]
name text(65535) [ not null ]
description text(65535) [ not null ]
}

Table matchDlcJunk [headercolor: #175e7a] {
dlcId integer [ pk, not null ]
matchId integer [ pk, not null ]
}

Table playerMatchQuestJunk [headercolor: #175e7a] {
playerMatchId integer [ pk, not null ]
questPosition integer [ pk, not null ]
playerPosition integer [ not null ]
}

Table matchQuestJunk [headercolor: #175e7a] {
matchId integer [ pk, not null ]
questId integer [ pk, not null ]
questPosition integer [ not null ]
}

Table playerMatchPersonalQuestJunk [headercolor: #175e7a] {
playerMatchId integer [ pk, not null ]
personalQuestId integer [ pk, not null ]
}

Table playerMatchTagsJunk [headercolor: #175e7a] {
playerMatchId integer [ pk, not null ]
tagId integer [ pk, not null ]
}

Ref fk_playerMatchTable_playerId_playerTable {
playerMatch.playerId > player.id [ delete: no action, update: no action ]
}

Ref fk_playerMatchTable_matchId_matchTable {
playerMatch.matchId > match.id [ delete: no action, update: no action ]
}

Ref fk_matchDlc_dlcId_dlcTable {
matchDlcJunk.dlcId - dlcTable.id [ delete: no action, update: no action ]
}

Ref fk_matchDlc_matchId_matchTable {
matchDlcJunk.matchId - match.id [ delete: no action, update: no action ]
}

Ref fk_playerMatchQuest_playerMatchId_playerMatch {
playerMatchQuestJunk.playerMatchId - playerMatch.id [ delete: no action, update: no action ]
}

Ref fk_playerPersonalQuestJunk_playerMatchId_playerMatch {
playerMatchPersonalQuestJunk.playerMatchId - playerMatch.id [ delete: no action, update: no action ]
}

Ref fk_playerPersonalQuestJunk_personalQuestId_personalQuestsTable {
playerMatchPersonalQuestJunk.personalQuestId - personalQuestsTable.id [ delete: no action, update: no action ]
}

Ref fk_playerMatchTagsJunk_tagId_tagsTable {
playerMatchTagsJunk.tagId - tagsTable.id [ delete: no action, update: no action ]
}

Ref fk_playerMatchTagsJunk_playerMatchId_playerMatch {
playerMatchTagsJunk.playerMatchId - playerMatch.id [ delete: no action, update: no action ]
}

Ref fk_matchQuestsTable_id_matchQuestJunk {
matchQuestsTable.id - matchQuestJunk.questId [ delete: no action, update: no action ]
}

Ref fk_matchQuestJunk_matchId_match {
matchQuestJunk.matchId - match.id [ delete: no action, update: no action ]
}