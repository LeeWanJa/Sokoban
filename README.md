### 😎요구사항
1. 아래의 문자열을 넘겨서 처리하는 함수를 작성한다.
```
Stage 1
#####
#OoP#
#####
=====
Stage 2
  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########
```
2. 위 값을 읽고 저장할 수 있는 적당한 객체(혹은 클래스)를 생성하고 문자열로부터 읽은 값을 변환해서 저장한다.
3. 객체에는 스테이지 정보 및 원래 지도 정보가 들어있어야 한다.
4. 다음의 형태로 각 스테이지 정보를 출력한다.
```
Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어 위치: 2행 4열

Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

가로크기: 11
세로크기: 7
구멍의 수: 4
공의 수: 4
플레이어 위치 4행 6열
```
----
### 👍풀이과정
요구사항을 토대로 입력 데이터를 정제하고 반환하는 클래스와 그 반환된 정보를 다시 조합하여 콘솔창에 출력하는 클래스로 역할을 나눴습니다.
PlaySokoban 클래스는 이 두 역할을 가진 클래스를 요구사항에 맞게 순서대로 출력하는 역할을 합니다.

- 목표 : 입력된 문자열을 각 스테이지 별로 구분하고, 구분된 문자열에서 필요한 정보(가로, 세로, 구멍의 수 등)를 추출하여 저장한다. 
- 실행 흐름<br>
  <img width="482" height="458" alt="image" src="https://github.com/user-attachments/assets/f18c25e4-9b27-4b63-af49-04e8f42a5199" />
  <br><br>PlaySokoban 객체의 run() 실행<br><br><br>


  <img width="742" height="416" alt="image" src="https://github.com/user-attachments/assets/beec33d6-b8c9-43c9-a153-7a75e5e806ca" />
  <br><br>StageSet의 static 메서드 createRefineStages() 메서드 실행 -> StageSet 객체 반환<br><br><br>


  <img width="736" height="396" alt="image" src="https://github.com/user-attachments/assets/b9e38468-e61c-4bf2-bcc4-64be9f91d8ed" />
  <br><br>인자로 받은 문자열은 구분자를 통해 나누어 문자열 배열에 저장 <br>-> 이후 각 요소별로 반복문을 돌며 static 메서드 returnRefinedStage() 실행 <br>-> Stage 객체 반환 <br>-> 반환된 Stage 객체들은 stageSet 이라는 ArrayList 자료구조에 저장 <br>-> stageSet의 정보를 매개변수로 하는 StageSet 객체 반환<br><br><br>


  <img width="918" height="560" alt="image" src="https://github.com/user-attachments/assets/be7b37b3-e93f-4654-92be-74ab256eb580" />
  <br><br>returnedRefinedStages()는 인자로 들어온 문자열 정보를 extractMapInfo(), extractRemainInfo() 메서드를 통해 정제<br>-> 정제된 정보들은 Stage 생성자의 인자가 되어 새로운 객체로 반환<br><br><br> 


  Stage 객체가 모인 리스트를, <br>필드로 갖는 StageSet 객체를,<br> printStageSet 클래스의 static 메서드 printStage() 메서드의 인자로 입력<br><br><br>
  

  <img width="748" height="510" alt="image" src="https://github.com/user-attachments/assets/9448e70a-b184-45a2-bd1f-3ecb8c86866a" />
  <br><br>StageSet 객체를 for문을 통해 Stage 객체의 정보들을 하나씩 출력<br><br>
---  
### 👌실행 결과
<br>
  <img width="292" height="756" alt="image" src="https://github.com/user-attachments/assets/61cd8b0a-56b6-472a-aecf-e376388f66cd" />

  
