# Frontend

```sh
프로젝트 진행 중에 변경될 확률 매우 높음, 최종변경 : 2021. 10. 27

Why? Component를 페이지 별이 아니라 기능 별로 묶은 이유
-> Component를 다른 페이지에서도 재사용 할 가능성이 있고, Component의 목적에도 맞다고 사려됨


src
├── assets
│		├── css            --- css 폴더
│		└── svg            --- svg 벡터 이미지 폴더
├── common
│		│   
│		├── lib
│		│   └── function.ts     ---반복사용되는 TS 스크립트 모아두기 // 기능별 분류 필요시 쪼개기
#       store는 구현하거나 브라우저 storage를 쓰거나 라이브러리 사용할지 미정
# │       └──store
# │		    ├── action.js     ---전역으로 사용하는 함수들 모아놓기 (axios, api호출 등)
# │		    ├── getter.js     ---state들 가져오는 getter
# │		    ├── mutation.js   ---state들 변경하는 setter
# │		    └── state.js      ---vue store에 저장할 state들 생성
├── components
│		├── commmon
│		│   ├── MyPage.vue
│		│   ├── SideNav.vue
│		│   └── 
│		├── community
│		│   ├── 
│		│   ├── 
│		│   └── 
│		├── cs
│		│   ├── DailyPage.vue
│		│   ├── StudyPage.vue
│		│   └── TestPage.vue
│		└── pop
│		    ├── ConfirmPop.vue
│		    ├── LoginPop.vue
│		    └── LogoutPop.vue
├── views
│		├── HomeView.vue    ---SPA 기본으로 사용하는 페이지
│		├── ErrorView.vue   ---존재하지 않는 url 핸들링
│		└── 
├── App.vue         ---vue 프로젝트 base APP, 테마나 기본 설정
README.md           ---프로젝트 소개 및 설명
vite.config.ts      ---vite설정 ts파일
```

## Recommended IDE Setup

VScode + Vue + Vite + Vetur + Live Server

## Project Setup

```sh
npm install
npm run dev
```

### Lint with [ESLint](https://eslint.org/)

```sh
npm run lint
```
