package dev.brian.com.bamby.ui.Login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView loginView;
    @Mock
    private LoginPresenterImpl loginPresenter;

    @Before
    public void setUp() throws  Exception{
        loginPresenter= new LoginPresenterImpl(loginView);
    }
    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception{
        when(loginView.onTestGetUsername()).thenReturn("");

    }

}