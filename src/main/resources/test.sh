curl -X GET "http://localhost:1453/api/user/me/"

curl -X POST "http://localhost:1453/api/user/register/" -H "Content-Type: application/json" -d '{"username": "aboba", "password": "123"}'

curl -X POST "http://localhost:1453/api/tournaments/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1" \
   -d '{"name": "123s32322", "startDate": "2022-10-10", "maxGames": 3, "approvalRatio": 0.6, "judgesIds": [1, 2], "teamsIds": [1, 2, 3, 4, 5] }'


# Match 2
curl -X POST "http://localhost:1453/api/matches/2/play-game/?winnerId=2" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/1/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/1/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/2/play-game/?winnerId=2" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/2/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/2/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/2/play-game/?winnerId=2" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/3/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/3/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"





# Match 3
curl -X POST "http://localhost:1453/api/matches/3/play-game/?winnerId=3" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/4/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/4/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/3/play-game/?winnerId=3" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/5/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/5/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/3/play-game/?winnerId=3" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/6/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/6/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"



# Match 5
curl -X POST "http://localhost:1453/api/matches/5/play-game/?winnerId=5" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/7/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/7/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/5/play-game/?winnerId=5" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/8/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/8/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/5/play-game/?winnerId=2" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/9/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/9/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"


# Match 6
curl -X POST "http://localhost:1453/api/matches/6/play-game/?winnerId=5" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/10/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/10/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/6/play-game/?winnerId=3" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/11/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/11/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"

curl -X POST "http://localhost:1453/api/matches/6/play-game/?winnerId=3" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/12/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 1"
curl -X POST "http://localhost:1453/api/games/12/approve/" \
   -H "Content-Type: application/json" \
   -H "user-id: 2"


#curl -X POST "http://localhost:1453/api/matches/2/drop/" \
#   -H "Content-Type: application/json" \
#   -H "user-id: 2"