package app.theone.controller

import app.theone.entity.User
import app.theone.service.UserService
import com.nhaarman.mockitokotlin2.reset
import com.nhaarman.mockitokotlin2.whenever
import configuration.TestContext
import configuration.XmlConfig
import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasSize


import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.junit.Before
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@RunWith(value = SpringRunner::class)
@ContextConfiguration(classes = [TestContext::class, XmlConfig::class])

@WebAppConfiguration
class IndexControllerTest {
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Test
    fun indexTest() {
        val user1 = User("test1", "password", "email", Date(), Date())
        val user2 = User("test2", "password2", "email2", Date(), Date())

        whenever(userService.allUsers()).then {
            listOf(user1, user2)
        }
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk)
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/site/index.jsp"))
                .andExpect(model().attribute("users", hasSize<Int>(3)))

        verify(userService, times(1)).allUsers()

    }

    @Before
    fun setUp() {
            reset(userService)
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
        }
}

//inline fun <reified E> hasSize(size: Int) : Matcher<Collection<E>> {
//    return hasSize(size)
//}
