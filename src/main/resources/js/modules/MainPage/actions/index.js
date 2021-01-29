import { FIND_TITLE_JOB_CREATED, FIND_TITLE_JOB_FINISHED } from "./actionConstants";



export const findTitle = (webSiteUrl) => {
    return (dispatch) => {
        let body = {
            url: webSiteUrl
        };
        let settings = { method: 'POST', headers: {'Content-Type' : 'application/json'}, body: JSON.stringify(body)};
        let url = '/find/title';
        fetch(url, settings)
            .then(response => response.json())
            .then((job) => {
                console.log("getting job  for title search:", job);
                dispatch({type: FIND_TITLE_JOB_CREATED, job});
                getJobResult(job.jobId, dispatch);
                return job;
            })
            .catch(error => console.error('Error during search title sending request' , error));
    }
};

const getJobResult = (jobId, dispatch) => {
        let settings = { method: 'GET', headers: {'Content-Type' : 'application/json'}};
        let url = '/search/title/job/' + jobId;
        fetch(url, settings)
            .then(response => response.json())
            .then((job) => {
                console.log("getting job result:", job);
                if(job.status === "DONE" || job.status === "ERROR"){
                    dispatch({type: FIND_TITLE_JOB_FINISHED, job});
                } else {
                    setTimeout(() => {
                        getJobResult(jobId, dispatch)
                    }, 1000);
                }

                return job;
            })
            .catch(error => console.error('Error during getting job result' , error));
};

