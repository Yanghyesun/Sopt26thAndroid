[1차 세미나 과제]

*constraintlayout의 chain style => packed, spread, weight
<img width="632" alt="스크린샷 2020-05-08 오후 11 27 37" src="https://user-images.githubusercontent.com/37995236/81416356-903f4e80-9184-11ea-8780-3f688c18d56d.png">


*intent

activity 화면 전환시 사용

*startactivityforresult

요청 코드를 보낸 후, 결과 코드를 받아 처리하는 방법


[2차 세미나 과제]

*Bottom Navigation, ViewPager, RecyclerView

Bottom Navigation은 item을 최소 3개 이상 추가해야 한다.

<img width="385" alt="스크린샷 2020-05-08 오후 11 01 16" src="https://user-images.githubusercontent.com/37995236/81416394-9f260100-9184-11ea-9951-63d4e905e0c5.png">


*RecyclerView의 itemDecoration, clipToPadding

itemDecoration은 item과 item의 일정한 간격을 주기 위한 방법이다. 즉 리사이클러뷰의 아이템 여백을 주는 방법이다.
clipToPadding은 recycler에 padding을 주면 스크롤 시 padding 이 그대로 남아있지만 clipToPadding=false 를 주면 스크롤시 padding 이 사라진다.


[3차 세미나 과제]

*폴더 구조

<img width="222" alt="스크린샷 2020-05-22 오후 11 34 46" src="https://user-images.githubusercontent.com/37995236/82678688-fcda4300-9c84-11ea-98bc-7cafaa833387.png">

*통신 준비

```
//회원가입
@POST("/user/signup")
fun requestSignup(
    @Body body: RequestSignUp
): Call<ResponseSignUp>

//로그인
@POST("/user/signin")
fun requestSignIn(
    @Body body: RequestLogin
):Call<ResponseLogin>
```


```
object RequestToServer {
    private const val BASE_URL = ""
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: NetworkService = retrofit.create(NetworkService::class.java)
}
```
