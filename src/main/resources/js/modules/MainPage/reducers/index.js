import { combineReducers } from 'redux';
import rootReducer from './rootReducer';

const combinedReducer = combineReducers({
    rootReducer
});

export default combinedReducer;