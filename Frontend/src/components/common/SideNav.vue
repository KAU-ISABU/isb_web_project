<script setup lang="ts">
    import {useRouter} from 'vue-router';
    const router = useRouter();

    const clickLogo = ()=>{
        router.push("/");
    }

    const clickNav = (num)=>{
        switch(num) {
            case 0 :
                router.push("/daily");
                break;
            case 1 :
                router.push("/study");
                break;
            case 2 :
                router.push("/test");
                break;
            case 3 :
                // router.push("/daily");
                break;
            case 4 :
                // router.push("/daily");
                break;
        }
    }
</script>

<template>
    <div class="h-screen">
        <div class="h-1/5 fixed left-0 top-0 cursor-pointer">
            <img src="@/assets/logo.svg" alt="logo" class="h-1/3 m-4" @click="clickLogo()">
        </div>
        <div class="h-5/6 w-1/12 fixed bottom-0 left-0 ">
            <div class="h-full w-full flex flex-col text-left text-l divide-y divide-dashed bg-gray-100">
                <div class="p-4 cursor-pointer font-bold" @click="clickNav(0)">
                    오늘의 CS
                </div>
                <div class="p-4 cursor-pointer font-bold" @click="clickNav(1)">
                    공부하기
                </div>
                <div class="p-4 cursor-pointer font-bold" @click="clickNav(2)">
                    모의시험
                </div>
                <div class="p-4 cursor-pointer font-bold" @click="clickNav(3)">
                    커뮤니티
                </div>
            </div>
            <div class="absolute h-12 bottom-0 pl-4">
                <div class="flex justify-between text-xs">
                    <div class="cursor-pointer mr-4">
                        로그인
                    </div>
                    <div class="cursor-pointer">
                        가입하기
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
