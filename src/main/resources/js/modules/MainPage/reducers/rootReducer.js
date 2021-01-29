import {FIND_TITLE_JOB_CREATED, FIND_TITLE_JOB_FINISHED} from './../actions/actionConstants';

const initialState = {
    currentJob: null,

};
function rootReducer(state = initialState, action) {

    switch (action.type){
        case FIND_TITLE_JOB_CREATED:
            return Object.assign({}, state, { currentJob: action.job });
        case FIND_TITLE_JOB_FINISHED:
            return Object.assign({}, state, { currentJob: action.job});
        default:
            return state;
    }
}

export default rootReducer;