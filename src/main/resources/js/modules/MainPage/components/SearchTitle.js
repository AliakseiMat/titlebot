import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import '../css/main.css';
import { findTitle } from '../actions/index';
import $ from "jquery";

class SearchTitle extends Component {

    constructor(props){
        super(props);
        this.formPreventDefault = this.formPreventDefault.bind(this);
        this.findTitle = this.findTitle.bind(this);
    }

    findTitle() {
        let webSiteUrl = $("#inputURL").val();
        console.log("webSiteUrl", webSiteUrl);
        this.props.findTitle(webSiteUrl);
    }

    formPreventDefault(e) {
        e.preventDefault();
    }

    render() {
        let searchJobInProgress = this.props.currentJob != null && (this.props.currentJob.status === "CREATED" || this.props.currentJob.status === "IN_PROGRESS");
        let title = (this.props.currentJob != null && this.props.currentJob.status === "DONE")?this.props.currentJob.title:null;
        let error = (this.props.currentJob != null && this.props.currentJob.status === "ERROR")?this.props.currentJob.error:null;
        return (
            <div>
                <form className="row g-3" onSubmit={this.formPreventDefault}>
                    <div className="col-auto">
                        <label htmlFor="inputURL" className="visually-hidden">Web site URL</label>
                        <input
                            type="text"
                            className="form-control"
                            id="inputURL"
                            placeholder="Web site URL"
                            disabled = {(searchJobInProgress)? "disabled" : ""}
                        />
                    </div>
                    <div className="col-auto">
                        <button
                            type="button" className="btn btn-primary mb-3"
                            onClick={this.findTitle}
                            disabled={searchJobInProgress}
                        >Find Title</button>
                    </div>
                </form>
                <div style={{ display: searchJobInProgress ? 'block' : 'none' }} className="spinner-border" role="status">
                    <span className="visually-hidden">Loading...</span>
                </div>
                <div
                    style={{ display: title != null ? 'block' : 'none' }}
                >
                    <span className="bold">Title: </span>{title}
                </div>
                <div
                    style={{ display: error != null ? 'block' : 'none' }}
                >
                    <span className="error">Error: </span>{error}
                </div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        currentJob: state.rootReducer.currentJob
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        findTitle: bindActionCreators(findTitle, dispatch)
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(SearchTitle);