create index IX_8EBD9B8D on es_ESClub (companyId);
create index IX_CA21A14F on es_ESClub (groupId);
create index IX_C8CB59A4 on es_ESClub (groupId, clubName);

create index IX_9C9ABFC8 on es_ESPlayerClub (clubId, active_);
create index IX_599911EC on es_ESPlayerClub (companyId);
create index IX_33D5236E on es_ESPlayerClub (groupId);
create index IX_78832D8C on es_ESPlayerClub (playerId);

create index IX_C9A8B59A on es_ESPlayerShotData (playerId);
create index IX_6AC16D58 on es_ESPlayerShotData (playerId, createDate);
create index IX_8EBFD840 on es_ESPlayerShotData (playerId, playerClubId);
create index IX_81F8C6BA on es_ESPlayerShotData (playerId, productSerialNo);

create index IX_F5F5D2A9 on es_ESShotDataSharing (companyId);
create index IX_98F4EF6B on es_ESShotDataSharing (groupId);
create index IX_B75CE12F on es_ESShotDataSharing (playerId);