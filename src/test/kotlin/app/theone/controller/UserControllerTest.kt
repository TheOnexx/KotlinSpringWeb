package app.theone.controller

import app.theone.entity.User
import app.theone.service.UserService
import com.nhaarman.mockitokotlin2.*
import configuration.TestContext
import configuration.XmlConfig
import configuration.kIs
import org.hamcrest.Matchers.*
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyLong
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*

@RunWith(value = SpringRunner::class)
@ContextConfiguration(classes = [TestContext::class, XmlConfig::class])

@WebAppConfiguration
class UserControllerTest {
    private val ID = 1L
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext


    @Test
    fun displayUserTest() {
        val user = User(ID, "test_name", "test_pass", "test_email", Date(), Date())

        whenever(userService.getUser(ID)).thenReturn(user)

        mockMvc.perform(get("/user/{id}", ID))
                .andExpect(status().isOk)
                .andExpect(view().name("user"))
               // .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user",
                        hasProperty<String>("userName", kIs("test_name"))))
                .andExpect(model().attribute("user",
                        hasProperty<String>("password", kIs("test_pass"))))
                .andExpect(model().attribute("user",
                        hasProperty<String>("email", kIs("test_email"))))
    }

    @Before
    fun setUp() {
        reset(userService)
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()

    }

}