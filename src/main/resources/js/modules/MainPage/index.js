import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from "redux";
import thunk from 'redux-thunk';
import combinedReducer from './reducers';
import App from './App';

let store  = createStore(combinedReducer, applyMiddleware(thunk));
let rootElement = document.getElementById("root");

ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>,
    rootElement
);